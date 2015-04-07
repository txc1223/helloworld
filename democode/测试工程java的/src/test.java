
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] s = new String[] { "1", "1", "2", "1", "2", "1", "2", "1", "1" };
		insertSort(s);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		
	}
	public static String[] insertSort(String[] args) {// ²åÈëÅÅÐòËã·¨
		for (int i = 1; i < args.length; i++) {
			for (int j = i; j > 0; j--) {
				String st = args[j];
				String st1 = args[j - 1];
				if (st.equals("2") && !st.equals("1")) {
					String temp = args[j - 1];
					args[j - 1] = args[j];
					args[j] = temp;
				} else
					break;
			}
		}
		return args;
	}
}
