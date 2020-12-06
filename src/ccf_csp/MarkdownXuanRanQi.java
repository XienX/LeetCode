package ccf_csp;
/*202006-3 Markdown渲染器
题目图见 https://blog.csdn.net/qq_44116998/article/details/107587355 

样例1输入：
10
CSP

CSP is
a real realrealrealrealreal 
     competition.

   
come   and   join   us   


样例1输出：
10

样例2输入：
10
* CSP
    
*   CSP is
  * a real  
     competition.
* 
  * Come!   and   join.
*Tel:
* 12345
* 
样例2输出：
14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MarkdownXuanRanQi {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		List<String> s = new ArrayList<>();
		int w = 0;
		String str = null;
		try{
			w = Integer.parseInt(bf.readLine());
			while((str = bf.readLine()) != null)
				s.add(str);
		} catch(Exception e) {}
		

		int w1 = w - 3;
		int i=0, len = s.size();
		int ans = 0;
		
		while (len > 0 && s.get(len-1).trim().length() == 0)
			len--;
		
		while (i < len && s.get(i).trim().length() == 0)
			i++;

		while (i < len) {
			if (s.get(i).trim().length() > 0) {
				if (s.get(i).startsWith("* ")) {
					StringBuilder tem = new StringBuilder(s.get(i++).substring(2).trim());
					while(i<len && s.get(i).trim().length()>0 && s.get(i).startsWith("  ")) 
						tem.append(' ').append(s.get(i++).trim());
					
					while(tem.length() > w1) {
						ans++;
						tem.delete(0, w1);
						while(tem.charAt(0) == ' ')
							tem.delete(0, 1);
					}
					
					if(i>=len || s.get(i).startsWith("* ")) 
						ans++;
					else ans += 2;
				}
				else {
					StringBuilder tem = new StringBuilder(s.get(i++).trim());
					while(i<len && s.get(i).trim().length()>0 && !s.get(i).startsWith("* ")) 
						tem.append(' ').append(s.get(i++).trim());
					
					while(tem.length() > w) {
						ans++;
						tem.delete(0, w);
						while(tem.charAt(0) == ' ')
							tem.delete(0, 1);
					}
					
					if(i>=len) 
						ans++;
					else ans += 2;
				}
			}
			else i++;
		}
		
		System.out.println(ans);
	}
}