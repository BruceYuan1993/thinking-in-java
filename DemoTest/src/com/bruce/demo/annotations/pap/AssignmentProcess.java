package com.bruce.demo.annotations.pap;

import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

public class AssignmentProcess extends AbstractProcessor{
	private TypeElement assignmentElement;
	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		// TODO Auto-generated method stub
		super.init(processingEnv);
		Elements utils = processingEnv.getElementUtils();
		assignmentElement = utils.getTypeElement("com.bruce.demo.annotations.pap.Assignment");
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void processAssignment(Element element) {
		List<? extends AnnotationMirror> annotationMirrors = element.getAnnotationMirrors();
		for (AnnotationMirror annotationMirror : annotationMirrors) {
			if(annotationMirror.getAnnotationType().asElement().equals(assignmentElement)){
				
			}
		}
	}

}
