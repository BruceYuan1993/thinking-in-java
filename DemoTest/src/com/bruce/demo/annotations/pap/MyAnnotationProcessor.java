package com.bruce.demo.annotations.pap;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;


@SupportedAnnotationTypes("com.bruce.demo.annotations.pap.ToBeTested")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class MyAnnotationProcessor extends AbstractProcessor{
	FileOutputStream outputStream = null;
	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		// TODO Auto-generated method stub
		for (TypeElement type : annotations) {
			note("Supported " + type.toString());
		}
		Set<? extends Element> elements  = roundEnv.getRootElements();
		for (Element element : elements) {
			List<? extends Element> enclosedElems = element.getEnclosedElements();
			List<? extends ExecutableElement> ees = ElementFilter.methodsIn(enclosedElems);
			for(ExecutableElement ee : ees){
				note("--ExecutableElement name is "+ee.getSimpleName()); 
				List<? extends AnnotationMirror>  as = ee.getAnnotationMirrors();
				note("--as="+as);  
				for (AnnotationMirror am : as) {
					Map<? extends ExecutableElement, ? extends AnnotationValue> map =
						am.getElementValues();
					Set<? extends ExecutableElement> keys = map.keySet();
					for (ExecutableElement key : keys){
						AnnotationValue value  = map.get(key);
						note(key + "---->" + value);
					}
				}
			 }
		}
		if (outputStream == null) {
			try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private void note(String msg){
		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, msg);
		try {
			if (outputStream == null) {
				outputStream = new FileOutputStream("result.text");
			}
			PrintStream ps = new PrintStream(outputStream);
			ps.println(msg);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
