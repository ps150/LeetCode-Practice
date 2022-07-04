package leetcodepractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {

 	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		if (strs.size() == 0)
			return this.toString();

		String d = this.toString();
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s);
			sb.append(d);
		}
		sb.delete(sb.lastIndexOf(d), sb.length());

		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
        String d = Character.toString((char)258);
        System.out.println("d value is" + d);
		if (s.equals(d))
			return new ArrayList<String>();
 
        d = this.toString();
		return Arrays.asList(s.split(d, -1));

	}
	public static void main(String[] args) {

		Codec soln = new Codec();
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");
		String str = soln.encode(list);
		System.out.println(str);

		List<String> items = soln.decode(str);
		for (String st : items)
			System.out.println(st);

	}

}
