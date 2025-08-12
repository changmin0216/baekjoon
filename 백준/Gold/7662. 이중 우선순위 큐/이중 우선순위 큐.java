import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 정렬-->리스트?????
		int T = Integer.parseInt(br.readLine());
		for (int tc=0;tc<T;tc++) {
			TreeMap<Integer, Integer> tm = new TreeMap<>();   
			int k = Integer.parseInt(br.readLine());
			for (int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String c = st.nextToken();
				int v = Integer.parseInt(st.nextToken());
				if(c.equals("I")) {
					if (!tm.containsKey(v)) {
						tm.put(v, 1);
					} else {
						tm.replace(v, tm.get(v)+1);
					}
				} else if(c.equals("D")) {
					if(!tm.isEmpty()) {
						int key = -1, cnt = -1;
						if(v==1) {
							key = tm.lastKey();
						} else {
							key = tm.firstKey();
						}
						cnt = tm.get(key);
						
						if (cnt==1) {
							tm.remove(key);
						}
						else {
							tm.replace(key, cnt-=1);
						}
					}
				}
			}
			
			if(tm.isEmpty()) System.out.println("EMPTY");
			else System.out.println(tm.lastKey()+" "+tm.firstKey());
		}
	}

}
