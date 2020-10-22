package leetcode.字符串;

//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 说明: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 示例: 
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to","explain
//",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics 字符串 
// 👍 107 👎 0


import java.util.ArrayList;
import java.util.List;

public class L68_TextJustification {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> res = new ArrayList<String>();
            int len = words.length;
            if (len < 1) return res;
            int cur = 0;
            while (cur < len) {
                int size = 0;
                size += words[cur].length();
                int next = cur + 1;
                //下一个单词能不能放入
                while (next < len && size + 1 + words[next].length() <= maxWidth) {
                    size = size + 1 + words[next].length();
                    next++;
                }
                String line = words[cur];
                //第一种：如果是最后一行，则从左到右依次排序。剩下的填充空格。
                if (next == len) {

                    for (int k = cur + 1; k < next; k++) {
                        line += " " + words[k];
                    }
                    //后面的空格
                    while (line.length() < maxWidth) {
                        line += " ";
                    }
                    res.add(line);
                } else {
                    //第二种：如果一行只有一个，则靠左，剩下的填充空格。
                    if (next - cur == 1) {
                        while (line.length() < maxWidth) {
                            line += " ";
                        }
                        res.add(line);
                    } else {
					/*第三种：正常行，正常个个数。首先，我们需要知道我们可以填充的空格总数spaces，等于L-单词站位总数，
					之后每一个间隔num可以填充的为spaces/num，前spaces/num可以多添加一个空格。*/
                        int interval = next - cur - 1;//间隔数
                        int actualLen = size - interval;//单词实际站位数
                        int spaces = maxWidth - actualLen;//可填充的总得空格数
                        int x = spaces / interval;//间隔的填充空格
                        int y = spaces % interval;//最后的填充空格
                        int count = 1;
                        for (int k = cur + 1; k < next; k++) {
                            for (int m = 0; m < x; m++) {
                                line += " ";
                            }
                            if (count <= y) {
                                line += " ";
                            }
                            count++;
                            line += words[k];
                        }
                        res.add(line);
                    }
                }
                cur = next;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L68_TextJustification().new Solution();

    }
}