#ifndef SUCCINCT_GRAPH_SERDE_H
#define SUCCINCT_GRAPH_SERDE_H

#include <cstdint>
#include <cassert>
#include <map>
#include <string>
#include <vector>

// Whether or not to alphabet-encode the timestamps and dst nodes. If set to
// false (0), just pad with 0 in decimal representation.
#define ALPHABET_ENCODE 0

// SerDe that should adhere to the private typedefs in SuccinctGraph.
class SuccinctGraphSerde {
public:

    /********** padding: left-pad with 0 **********/

    static std::string pad_node_id(int64_t x);
    static std::string pad_atype(int64_t x);
    static std::string pad_edge_width(int32_t x);

    // Uses exactly 2 chars to represent dst id width & timestamp width.
    inline static std::string pad_dst_id_width(int32_t x) {
        assert(x <= WIDTH_NODE_ID_PADDED);
        if (x < 10) return '0' + std::to_string(x);
        return std::to_string(x);
    }
    inline static std::string pad_timestamp_width(int32_t x) {
        assert(x <= WIDTH_NODE_ID_PADDED);
        if (x < 10) return '0' + std::to_string(x);
        return std::to_string(x);
    }

    /********** encoding: left-pad with 0 **********/

    static std::string encode_timestamp(
        int64_t timestamp, int32_t padded_width);

    static int64_t decode_timestamp(const std::string& encoded);

    static std::vector<int64_t> decode_multi_timestamps(
        const std::string& encoded,
        int32_t padded_width);

    static std::string encode_node_id(int64_t node_id);

    static std::string encode_node_id(int64_t node_id, int32_t padded_width);

    static int64_t decode_node_id(const std::string& encoded);

    static std::vector<int64_t> decode_multi_node_ids(
        const std::string& encoded,
        int32_t padded_width);

    // Maximum width (# of decimal digits) of node IDs.
    constexpr static int WIDTH_NODE_ID_PADDED = 20;

    // 2 decimal digits upper-bounds the width of any int64
    constexpr static int WIDTH_DST_ID_WIDTH_PADDED = 2;
    constexpr static int WIDTH_TIMESTAMP_WIDTH_PADDED = 2;

private:

    // Left-pads with zeros to 10 chars (with alphabet 0-9).
    static std::string pad_int32(int32_t x);

    // Left-pads with zeros to 20 chars (with alphabet 0-9).
    static std::string pad_int64(int64_t x);

    static std::vector<int64_t> unpad_multi_int64(const std::string& encoded);

    // Encodes decimal input to base alphabet, optionally padding the result
    // according to padded_width (with leading 0).
    static std::string encode_int64(int64_t x, int padded_width);

    // Decodes from base alphabet to decimal, treating as a single encoded elem.
    static int64_t decode_int64(const std::string& encoded);

    static std::string encode_int32(int32_t x, int padded_width);
    static int32_t decode_int32(const std::string& encoded);

    static std::vector<int64_t> decode_multi_int64(const std::string& encoded,
                                                   int padded_width);

    static void parse_multi_int64(
        std::vector<int64_t>& result,
        const std::string& encoded,
        int pad_width);

    const static std::string ENCODE_ALPHABET;
    const static int SIZE_ENCODE_ALPHABET;

    static std::map<char, int> init_map();
    static std::map<char, int> alphabet_char2pos;

};

#endif
