package greedy;

import java.util.*;

public class HuffmanCoding {

    static class Node implements Comparable<Node> {
        char data;
        int cost;
        Node left;
        Node right;

        Node(char data, int cost) {
            this.data = data;
            this.cost = cost;
        }

        Node(Node left, Node right) {
            this.left = left;
            this.right = right;
            this.cost = left.cost + right.cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    HashMap<Character, String> encoder = new HashMap<>();
    HashMap<String, Character> decoder = new HashMap<>();

    public HuffmanCoding(String feeder) {

        // Step 1: Count frequencies
        HashMap<Character, Integer> fmap = new HashMap<>();

        for (int i = 0; i < feeder.length(); i++) {
            char ch = feeder.charAt(i);

            if (fmap.containsKey(ch)) {
                fmap.put(ch, fmap.get(ch) + 1);
            } else {
                fmap.put(ch, 1);
            }
        }

        // Step 2: Create priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : fmap.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            pq.add(node);
        }

        // Step 3: Build Huffman Tree
        while (pq.size() > 1) {

            Node first = pq.remove();
            Node second = pq.remove();

            Node merged = new Node(first, second);

            pq.add(merged);
        }

        // Step 4: Generate codes
        Node root = pq.remove();
        initEncoderDecoder(root, "");
    }

    private void initEncoderDecoder(Node node, String output) {

        if (node.left == null && node.right == null) {
            encoder.put(node.data, output);
            decoder.put(output, node.data);
            return;
        }

        initEncoderDecoder(node.left, output + "0");
        initEncoderDecoder(node.right, output + "1");
    }

    public String encode(String source) {

        String ans = "";

        for (int i = 0; i < source.length(); i++) {
            ans += encoder.get(source.charAt(i));
        }

        return ans;
    }

    public String decode(String codedString) {

        String ans = "";
        String key = "";

        for (int i = 0; i < codedString.length(); i++) {

            key += codedString.charAt(i);

            if (decoder.containsKey(key)) {
                ans += decoder.get(key);
                key = "";
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String str = "abracadabra";

        HuffmanCoding hf = new HuffmanCoding(str);

        String encoded = hf.encode(str);
        System.out.println("Encoded: " + encoded);

        String decoded = hf.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}