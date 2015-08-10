
public class KavaClassLoader extends ClassLoader {
	public Class defineClass(String name,byte[] bs){
		return this.defineClass(name, bs, 0, bs.length);
	}
}
