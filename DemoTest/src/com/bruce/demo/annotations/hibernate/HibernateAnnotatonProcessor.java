package com.bruce.demo.annotations.hibernate;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;


@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class HibernateAnnotatonProcessor extends AbstractProcessor{
	
	private void note(String msg) {
		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, msg);
	}
	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		// TODO Auto-generated method stub
		 //= roundEnv.getRootElements();
		Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Property.class);
		for (Element element : elements) {
			element.accept(new HibernateAnnotationVistor<String, String>(), "test");
		}
		return false;
	}
	
	private class HibernateAnnotationVistor<R,P> implements ElementVisitor<R, P>{

		@Override
		public R visit(Element e) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public R visit(Element e, P p) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public R visitExecutable(ExecutableElement e, P p) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public R visitPackage(PackageElement e, P p) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public R visitType(TypeElement e, P p) {
			// TODO Auto-generated method stub
			note(e.getSimpleName().toString());
			return null;
		}

		@Override
		public R visitTypeParameter(TypeParameterElement e, P p) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public R visitUnknown(Element e, P p) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public R visitVariable(VariableElement e, P p) {
			// TODO Auto-generated method stub
			note(e.getSimpleName().toString());
			return null;
		}
		
	}

}
