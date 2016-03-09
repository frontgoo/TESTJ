import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Notice:
 * <BR> 1. 仅限使用以下package:
 *		java.lang.*, java.io.*, java.math.*, java.text.*, java.util.*
 * <BR> 2. 请勿变更 package名，类名，test()定义。 
 *
 */
public class ProgramTest {

	/**
	 * 请在此方法内完成代码，但可以增加自己的私有方法。
	 * 数据文件inputFile的内容格式为一行一条数据，每条数据有2个字段用逗号分隔，第1个字段为排序用的Key，第二个字段为value。
	 * 换行符为'\n'。
	 * 数据内容举例如下:
	 * abe,xmflsflmfmlsmfs
	 * abc,xmlmxlkmffhf
	 * 8fj3l,xxjfluu313ooo11
	 * 
	 * 注意点: 1.本次的测试数据内容都是ASCII字符，无中文汉字.所以不必考虑encoding。
	 *        2.本次的测试数据中,key的最大长度8，value的最大长度32。
	 * 
	 * 排序以key的升序，使用String.compareTo()来比较key的大小。最后排序完成的数据写入outputFile。
	 * @param inputFile 输入文件
	 * @param outputFile 输出文件
	 * @param tempFile 临时文件。处理的数据量大的时候，可能会需要用到临时文件。
	 * @throws Exception
	 */
	public static void test(File inputFile, File outputFile, File tempFile) throws Exception {
		//TODO ====================== YOUR CODE HERE ======================
		inputFile = new File("H:\\git\\rep\\TESTJ\\src\\test\\resources\\input.data");
		outputFile = new File("H:\\git\\rep\\TESTJ\\src\\test\\resources\\output.data");

		BufferedReader bi = new BufferedReader(new FileReader(inputFile));
		BufferedWriter bo = new BufferedWriter(new FileWriter(outputFile));
		String line = bi.readLine();
		List<String> all = new ArrayList<String>();
		while (line!=null){
			all.add(line);
			line = bi.readLine();
		}
		for (int j = 0; j < all.size() - 1; j++) {
			for (int k = j+1; k < all.size(); k++) {
				String key2 = null;
				String key1 = all.get(j).split("\\,")[0];
				try{
					key2 = all.get(k).split("\\,")[0];
				}
				catch (Exception e){
					System.out.println("key1:"+key1+" key2:"+key2+" k:"+k);
				}

				if (key1.compareTo(key2)>0){
					if (key1 == null){
						System.out.println("key1:"+key1+"--"+k);
					}
					String temp = all.get(j);
					all.set(j,all.get(k));
					all.set(k,temp);
				}
			}
		}
		for (String s:all) {
			bo.append(s+"\n");
		}
		bo.flush();
		bo.close();
		bi.close();

		//=================================================================
	}
	
	
	//TODO ====================== YOUR CODE HERE (You can add private method if need) ======================
	
	public static void main(String args[]) throws Exception {
		test(null,null,null);
	}
	//=================================================================
}
