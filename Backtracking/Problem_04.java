package Backtracking;

import java.util.ArrayList;
import java.util.List;

// Restore IP addresses
public class Problem_04 {
    public static List<String> restoreIpAddresses(String s) {
      List<String> res = new ArrayList<String>();
      backtrack(0,0,"",s,res);
      return res;
  }

  public static void backtrack(int start, int dots,String ip,String s, List<String> res){
    if(start == s.length() && dots == 4){
      res.add(ip.substring(0,ip.length()-1));
      return;
    }
    if(dots > 4)
      return;
    for(int end = start; end < Math.min(start+3,s.length()); end++){
      int val = Integer.parseInt(s.substring(start,end+1));
      if(val <= 255 && (end == start || s.charAt(start) != '0'))
        backtrack(end+1,dots+1,ip + s.substring(start,end+1) + ".",s,res);
    }
  }
}
