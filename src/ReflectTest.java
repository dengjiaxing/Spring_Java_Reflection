import java.io.File;
import java.lang.reflect.Field;
import java.time.chrono.JapaneseChronology;

public class ReflectTest {
	
	private String fname;
	private String lname;
	public ReflectTest(String fname,String lname) {
		// TODO Auto-generated constructor stub
		this.fname=fname;
		this.lname=lname;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReflectTest rt=new ReflectTest("java", "aspectj");
		fun(rt);
	}
	public static void fun(Object obj){
		Field[] fields=obj.getClass().getDeclaredFields();
		System.out.println("�滻֮ǰ�ģ�");
		try {
			for(Field field: fields){
				System.out.println(field.getName()+"="+field.get(obj));
				if (field.getType().equals(java.lang.String.class)) {
					field.setAccessible(true);//����Ϊtrue�ſ����޸ĳ�Ա����
					String org=(String) field.get(obj);
					field.set(obj, org.replace("a", "b"));
					//��field�е�ǰ��ŵ�obj���������ֵ�������ֵ�����a�滻��b
				}
			}
			System.out.println("�滻֮��");
			for(Field field:fields){
				System.out.println(field.getName()+"="+field.get(obj));
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
