package LeetCode_June_Challenge.Week_3;

import java.util.HashSet;
import java.util.Set;

public class Longest_Duplicate_Substring {

	public static void main(String[] args) {
		String s = "banana";
		System.out.println(longestDuplicateSS2(s));
	}
	
	public static String longestDuplicateSS(String S) {
        int ans = 0;
		int[][] strg = new int[S.length()][S.length()];
		int maxL = 0;
		int lastIdx = -1;
		for(int i = 0; i<S.length(); i++) {
			for(int j = i+1; j<S.length(); j++) {
				if(S.charAt(i) == S.charAt(j)) {
					if(i == 0)
						strg[i][j] = 1;
					else
						strg[i][j] = strg[i-1][j-1]+1;
					if(strg[i][j] > maxL) {
						maxL = strg[i][j];
						lastIdx = j;
					}
				}
			}
		}
		return S.substring(lastIdx-maxL+1, lastIdx+1);

    }
	
	public static String longestDuplicateSS1(String S) {
		
		int[] strg = new int[S.length()];
		int maxL = 0;
		int lastIdx = -1;
		for(int i = 0; i<S.length(); i++) {
			int prev = strg[i];
			for(int j = i+1; j<S.length(); j++) {
				int temp = strg[j];
				if(S.charAt(i) == S.charAt(j)) {
					if(prev != 0)
						strg[j] = prev+1;
					else
						strg[j] = 1;
					if(strg[j] > maxL) {
						maxL = strg[j];
						lastIdx = j;
					}
				}else
					strg[j] = 0;
				prev = temp;
			}
		}
		return S.substring(lastIdx-maxL+1, lastIdx+1);
		
	}
	
	public static String longestDuplicateSS2(String S) {
		Set<String> set = new HashSet<>();
		int maxL = 0;
		String maxStr = "";
		for(int i = 0; i<S.length(); i++) {
			for(int j = i+maxL; j<S.length() && j-i<=100; j++) {
				
				String ss = S.substring(i, j+1);
				if(!set.contains(ss)) {
					set.add(ss);
				}else {
					maxL = ss.length();
					maxStr = ss;
				}
				
			}
		}
		return maxStr;
	}
/*
private String S;

// T = O(N*K), S = O(N), where N is length of S and K avg depth of trie.
public String longestDupSubstring(String S) {
    this.S = S;
    int maxLo = 0, maxLength = 0;
    TrieNode root = new TrieNode(0, 0);
    for (int i = 1; i + maxLength < S.length(); i++) {
        int len = addNew(root, i);
        if (len > maxLength) {
            maxLength = len;
            maxLo = i;
        }
    }
    return S.substring(maxLo, maxLo + maxLength);
}

private boolean isLeaf(TrieNode node) {
    return node.next == null;
}

private int getIndex(int i, int depth) {
    return S.charAt(i + depth) - 'a';
}

private int addNew(TrieNode node, int i) {
    int depth = node.depth;
    if (i + depth == S.length()) return depth;
    if (isLeaf(node)) {
        node.next = new TrieNode[26];
        node.next[getIndex(node.i, node.depth)] = new TrieNode(node.i, depth + 1);
    }
    int c = getIndex(i, node.depth);
    TrieNode x = node.next[c];
    if (x == null) {
        node.next[c] = new TrieNode(i, depth + 1);
        return depth;
    }
    return addNew(x, i);
}

private static class TrieNode {
    private TrieNode[] next;
    private int i;
    private int depth;

    public TrieNode(int i, int depth) {
        this.i = i;
        this.depth = depth;
    }
}
 */
	
	
}
