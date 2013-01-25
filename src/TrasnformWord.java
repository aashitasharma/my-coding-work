import java.util.*;
public class TrasnformWord {

	/**
	 * @param args
	 */
	public static List<String> getAllTranformations(String src, Set<String> dictionary) {
		List<String> results = new LinkedList<String>();
		for(int i = 0; i < src.length(); i++) {
			for(char c = 'A'; c <= 'Z'; c++) {
				String newString = src.substring(0,i) + c + src.substring(i+1);
				if(!src.equals(newString) && dictionary.contains(newString)) {
					results.add(newString);
				}
			}
		}
		System.out.println(results);
		return results;
	}
	public static List<String> transform(String src, String dest, Set<String> dictionary) {
		Queue<String> Q = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		Map<String, String> routes = new HashMap<String, String>();
		Q.add(src);
		visited.add(src);
		while(!Q.isEmpty()) {
			String t = Q.poll();
			if(t.equals(dest)) {
				LinkedList<String> list = new LinkedList<String>();
				while(t != null) {
					list.add(0,t);
					t=routes.get(t);
				}
				return list;
			}
			for(String s : getAllTranformations(t, dictionary)) {
				if(!visited.contains(s)) {
					visited.add(s);
					Q.add(s);
					routes.put(s,t);
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("LAMP");
		dictionary.add("LIMP");
		dictionary.add("LIME");
		dictionary.add("LIKE");
		dictionary.add("LIEM");
		List<String> result = new LinkedList<String>(); 
		result = transform("DAMP", "LIKE", dictionary);
		System.out.println(result);
	}

}
