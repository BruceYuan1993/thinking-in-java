package bruce.yuan.instrument;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class MySizeOf {
	private static Instrumentation inst;


	public static void premain(String options, Instrumentation instp){
		inst = instp;
		

		//		  if (options != null) {
//			  instp.addTransformer(new Timing(options));
//	      } else {
//	            System.out
//	                    .println("Usage: java -javaagent:Timing.jar=\"class:method\""); 
//	            System.exit(0);
//	      }
		//instp.addTransformer(new Transformer());
		//class
		
		try {
			ClassDefinition definition = new ClassDefinition(Class.forName("com.bruce.demo.instrument.TransClass"), 
					Transformer.getBytesFromFile("D:\\TransClass2.class"));
			instp.redefineClasses(definition);
			System.out.println("Success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnmodifiableClassException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static long sizeOf(Object o){
		if(inst == null) {
		throw new IllegalStateException("Can not access instrumentation environment.\n" +
			"Please check if jar file containing SizeOfAgent class is \n" +
			"specified in the java's \"-javaagent\" command line argument.");
		}
		return inst.getObjectSize(o);
	}
}
