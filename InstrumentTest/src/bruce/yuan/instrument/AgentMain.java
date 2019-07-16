package bruce.yuan.instrument;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class AgentMain {
	public static void agentMain(String options, Instrumentation inst){
		
		try {
			inst.addTransformer(new Transformer());
			inst.retransformClasses(Transformer.class);
			System.out.println("Agent Main Done");
		} catch (UnmodifiableClassException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
