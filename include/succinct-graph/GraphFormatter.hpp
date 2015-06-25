#ifndef GRAPH_FORMATTER_H
#define GRAPH_FORMATTER_H

#include <string>
#include <vector>

// Formats input files into Succinct Graph-ready files.
class GraphFormatter {
public:

    // node_file: each row contains attributes (bytes) for the node
    //              whose ID is current row number - 1
    // output: "A.node" -> "A.node_formatted", each attr separated by
    //         pre-defined unique delimiters
    static void format_node_file(const std::string& node_file);

    // Outputs random node table, where each line's attributes are properly
    // separated by unique delimiters.
    static void create_random_node_table(
        const std::string& out_file,
        int num_nodes,
        int num_attr,
        int freq,
        int len);

    // Outputs a node table file suitable for use in SuccinctGraph::construct().
    // Each node's attributes are taken from `attr_file`, and are properly
    // separated by unique delimiters (specified in SuccinctGraph::DELIMITERS).
    //
    // Asserts that any internal delimiters used do not appear in attr contents.
    static void create_node_table(
        const std::string& out_file,
        const std::string& attr_file,
        int num_nodes,
        int num_attr,
        int freq,
        int len);

    // Each line is of the form "176481 2417 1341102251 MT" (map
    // MT->0, RE->1, RT->2 as atypes); if `has_atype_timestamp` is false, then
    // each line is just "srcId dstId", and we generate atype and timestamp
    // uniformly at random from some range.
    // Edge attributes taken from `attr_file`, with truncation/padding so that
    // each attribute has specified length.  The output edge file can be fed
    // into SuccinctGraph::construct().
    static void format_higgs_twitter_dataset(
        const std::string& file,
        const std::string& attr_file,
        const std::string& out_file,
        int bytes_per_attr,
        bool has_atype_timestamp = true,
        int num_atype = 5);

    // Applies special delimiter logic: prepend each attribute with a unique
    // delimiter that doesn't appear in the input; concatenates these into a
    // string, then takes care of appending delimiters for absent attributes.
    // Concatenates the result strings with new lines (including at the end).
    // The output is suitable to be used in SuccinctGraph::construct().
    static std::string format_node_attrs_str(
        std::vector<std::vector<std::string>> node_attrs);

    // Used only when generating & parsing queries, not part of the internal
    // graph layout.  Assumes this is char uniquely identifiable (among attrs).
    static const char QUERY_FILED_DELIM = '\x02';

};

#endif