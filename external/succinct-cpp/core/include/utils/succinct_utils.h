#ifndef SUCCINCT_UTILS_H
#define SUCCINCT_UTILS_H

#include <cstdint>
#include <string>
#include <sys/mman.h>
#include <sys/types.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
#include <iostream>
#include <fstream>

#include "assertions.h"
#include "definitions.h"

#ifndef MAP_HUGETLB
#define MAP_HUGETLB 0
#endif

#ifndef MAP_POPULATE
#define MAP_POPULATE 0
#endif

class SuccinctUtils {
 public:
  // Returns the number of set bits in a 64 bit integer
  static uint64_t PopCount(uint64_t n) {
    // TODO: Add support for hardware instruction

// Defining them here & undef'ing immediately, since some of these
// crash with boost/thread/lock_algorithms.hpp.
#define m1   0x5555555555555555 //binary: 0101...
#define m2   0x3333333333333333 //binary: 00110011..
#define m4   0x0f0f0f0f0f0f0f0f //binary:  4 zeros,  4 ones ...
#define m8   0x00ff00ff00ff00ff //binary:  8 zeros,  8 ones ...
#define m16  0x0000ffff0000ffff //binary: 16 zeros, 16 ones ...
#define m32  0x00000000ffffffff //binary: 32 zeros, 32 ones
#define hff  0xffffffffffffffff //binary: all ones
#define h01  0x0101010101010101 //the sum of 256 to the power of 0,1,2,3...

    n -= (n >> 1) & m1;
    n = (n & m2) + ((n >> 2) & m2);
    n = (n + (n >> 4)) & m4;
    return (n * h01) >> 56;

#undef m1
#undef m2
#undef m4
#undef m8
#undef m16
#undef m32
#undef hff
#undef h01
  }

  // Returns integer logarithm to the base 2
  static uint32_t IntegerLog2(uint64_t n) {
    // TODO: Add support for hardware instruction
    uint32_t l = ISPOWOF2(n) ? 0 : 1;
    while (n >>= 1)
      ++l;
    return l;
  }

  // Returns a modulo n
  static uint64_t Modulo(int64_t a, uint64_t n) {
    while (a < 0)
      a += n;
    return a % n;
  }

  // Computes the number of blocks of block_size in val
  static uint64_t NumBlocks(uint64_t val, uint64_t block_size) {
    return (val % block_size) == 0 ? (val / block_size) : (val / block_size) + 1;
  }

  // Computes the max between two integers
  static int64_t Max(int64_t first, int64_t second) {
    return (first > second) ? first : second;
  }

  // Computes the min between two integers
  static int64_t Min(int64_t first, int64_t second) {
    return (first < second) ? first : second;
  }

  // Memory maps a file and returns a pointer to it
  static void* MemoryMap(std::string filename) {
    struct stat st;
    stat(filename.c_str(), &st);

    int fd = open(filename.c_str(), O_RDONLY, 0);
    assert(fd != -1);

    // Try mapping with huge-pages support
    void *data = mmap(NULL, st.st_size, PROT_READ,
    MAP_SHARED | MAP_HUGETLB | MAP_POPULATE,
                      fd, 0);

    // Revert to mapping with huge page support in case mapping fails
    if (data == (void *) -1) {
      fprintf(
          stderr,
          "mmap with MAP_HUGETLB option failed; trying without MAP_HUGETLB flag...\n");
      data = mmap(NULL, st.st_size, PROT_READ,
      MAP_SHARED | MAP_POPULATE,
                  fd, 0);
    }
    madvise(data, st.st_size, POSIX_MADV_RANDOM);
    assert(data != (void * )-1);

    return data;
  }

  // Memory maps a file and returns a pointer to it
  static void* MemoryMapUnpopulated(std::string filename) {
    struct stat st;
    stat(filename.c_str(), &st);

    int fd = open(filename.c_str(), O_RDONLY, 0);
    assert(fd != -1);

    // Try mapping with huge-pages support
    void *data = mmap(NULL, st.st_size, PROT_READ, MAP_SHARED | MAP_HUGETLB, fd,
                      0);

    // Revert to mapping with huge page support in case mapping fails
    if (data == (void *) -1) {
      fprintf(
          stderr,
          "mmap with MAP_HUGETLB option failed; trying without MAP_HUGETLB flag...\n");
      data = mmap(NULL, st.st_size, PROT_READ, MAP_SHARED, fd, 0);
    }
    madvise(data, st.st_size, POSIX_MADV_RANDOM);
    assert(data != (void * )-1);

    return data;
  }

  // Memory maps a file and returns a pointer to it
  static void* MemoryMapMutable(std::string filename) {
    struct stat st;
    stat(filename.c_str(), &st);

    int fd = open(filename.c_str(), O_RDWR, 0);
    assert(fd != -1);

    // Try mapping with huge-pages support
    void *data = mmap(NULL, st.st_size, PROT_READ | PROT_WRITE,
    MAP_PRIVATE | MAP_HUGETLB | MAP_POPULATE,
                      fd, 0);

    // Revert to mapping with huge page support in case mapping fails
    if (data == (void *) -1) {
      fprintf(
          stderr,
          "mmap with MAP_HUGETLB option failed; trying without MAP_HUGETLB flag...\n");
      data = mmap(NULL, st.st_size, PROT_READ | PROT_WRITE,
      MAP_PRIVATE | MAP_POPULATE,
                  fd, 0);
    }
    madvise(data, st.st_size, POSIX_MADV_RANDOM);
    assert(data != (void * )-1);

    return data;
  }

  static void Unmap(void *data, std::string filename) {
    struct stat st;
    stat(filename.c_str(), &st);
    munmap(data, st.st_size);
  }

  // Writes an integer array to file
  template<typename T>
  static void WriteToFile(T* data, size_t size, std::string outfile) {
    std::ofstream out(outfile);
    out.write(reinterpret_cast<const char *>(data), size * sizeof(T));
    out.close();
  }
};

#endif
