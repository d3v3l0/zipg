#include "SuccinctGraphSerde.hpp"
#include "utils.h"

#include <cassert>

const int SuccinctGraphSerde::SIZE_ENCODE_ALPHABET = 64; // 10+26+26+2
const std::string SuccinctGraphSerde::ENCODE_ALPHABET =
    "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz\x03\x04";

std::string SuccinctGraphSerde::pad_node_id(int64_t x) {
    return pad_int64(x);
}

std::string SuccinctGraphSerde::pad_atype(int64_t x) {
    return pad_int64(x);
}

std::string SuccinctGraphSerde::pad_edge_width(int32_t x) {
    return pad_int32(x);
}

inline void SuccinctGraphSerde::parse_multi_int64(
    std::vector<int64_t>& result,
    const std::string& encoded,
    int pad_width)
{
    assert(encoded.length() % pad_width == 0);
    result.reserve(encoded.length() / pad_width);
    int64_t num;
    for (size_t i = 0; i < encoded.length(); i += pad_width) {
        num = 0;
        for (int j = i; j < i + pad_width; ++j) {
            num = num * 10 + (encoded[j] - '0');
        }
        result.push_back(num);
    }
    return;
}

std::string SuccinctGraphSerde::encode_timestamp(
    int64_t timestamp, int32_t padded_width)
{
    char* res = new char[padded_width + 1];
    sprintf(res, "%0*lld", padded_width, timestamp);
    return std::string(res);
}

int64_t SuccinctGraphSerde::decode_timestamp(const std::string& encoded)
{
#if ALPHABET_ENCODE
    return decode_int64(encoded);
#else
    return std::stoll(encoded);
#endif
}

std::vector<int64_t> SuccinctGraphSerde::decode_multi_timestamps(
    const std::string& encoded, int32_t padded_width)
{
    std::vector<int64_t> result;
    parse_multi_int64(result, encoded, padded_width);
    return result;
}

std::string SuccinctGraphSerde::encode_node_id(int64_t node_id) {
    return pad_int64(node_id);
}

// TODO: code duplication.
std::string SuccinctGraphSerde::encode_node_id(
    int64_t node_id,
    int32_t padded_width)
{
    char res[padded_width + 1];
    sprintf(res, "%0*lld", padded_width, node_id);
    return std::string(res);
}

int64_t SuccinctGraphSerde::decode_node_id(const std::string& encoded) {
#if ALPHABET_ENCODE
    return decode_int64(encoded);
#else
    return std::stol(encoded);
#endif
}

std::vector<int64_t> SuccinctGraphSerde::decode_multi_node_ids(
    const std::string& encoded,
    int32_t padded_width)
{
    std::vector<int64_t> result;
    parse_multi_int64(result, encoded, padded_width);
    return result;
}

std::map<char, int> SuccinctGraphSerde::alphabet_char2pos =
    SuccinctGraphSerde::init_map();

std::map<char, int> SuccinctGraphSerde::init_map() {
    std::map<char, int> map;
    for (size_t i = 0; i < ENCODE_ALPHABET.length(); ++i) {
        map[ENCODE_ALPHABET.at(i)] = i;
    }
    assert(map.size() == SIZE_ENCODE_ALPHABET);
    return map;
}

std::string SuccinctGraphSerde::pad_int32(int32_t x) {
    char res[11];
    sprintf(res, "%010d", x);
    return std::string(res);
}

std::string SuccinctGraphSerde::pad_int64(int64_t x) {
    char res[21];
    sprintf(res, "%020lld", x);
    return std::string(res);
}

std::string SuccinctGraphSerde::encode_int64(int64_t x, int padded_width) {
    assert(ENCODE_ALPHABET.length() == SIZE_ENCODE_ALPHABET);
    std::string res((size_t) padded_width, '0');
    int i = padded_width - 1;
    while (x != 0) {
        res[i] = ENCODE_ALPHABET[x % SIZE_ENCODE_ALPHABET];
        x /= SIZE_ENCODE_ALPHABET;
        --i;
    }
    assert(i >= 0);
    return res;
}

int64_t SuccinctGraphSerde::decode_int64(const std::string& encoded) {
    int64_t res = 0;
    int len = encoded.size();
    for (int i = 0; i < len; ++i) {
        res = res * SIZE_ENCODE_ALPHABET +
            alphabet_char2pos.at(encoded[i]);
    }
    return res;
}

std::string SuccinctGraphSerde::encode_int32(int32_t x, int padded_width) {
    assert(ENCODE_ALPHABET.length() == SIZE_ENCODE_ALPHABET);
    std::string res((size_t) padded_width, '0');
    int i = padded_width - 1;
    while (x != 0) {
        res[i] = ENCODE_ALPHABET[x % SIZE_ENCODE_ALPHABET];
        x /= SIZE_ENCODE_ALPHABET;
        --i;
    }
    assert(i >= 0);
    return res;
}

int32_t SuccinctGraphSerde::decode_int32(const std::string& encoded) {
    int32_t res = 0;
    int len = encoded.size();
    for (int i = 0; i < len; ++i) {
        res = res * SIZE_ENCODE_ALPHABET +
            alphabet_char2pos.at(encoded[i]);
    }
    return res;
}

// Unused
std::vector<int64_t>
SuccinctGraphSerde::decode_multi_int64(const std::string& encoded,
                                       int padded_width) {
    int len = encoded.length();
    assert(len >= padded_width);
    if (len > padded_width) assert(len % padded_width == 0);

    std::vector<int64_t> res;
    for (int i = 0; i < len; i += padded_width) {
        res.push_back(decode_int64(encoded.substr(i, padded_width)));
    }
    return res;
}

std::vector<int64_t>
SuccinctGraphSerde::unpad_multi_int64(const std::string& encoded) {
    // impl detail: assumes node ids 64 bits
    std::vector<int64_t> result;
    parse_multi_int64(result, encoded, WIDTH_NODE_ID_PADDED);
    return result;
}
