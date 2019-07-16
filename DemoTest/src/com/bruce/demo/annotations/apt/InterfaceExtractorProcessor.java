package com.bruce.demo.annotations.apt;

import java.io.PrintWriter;
import java.util.ArrayList;



import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.Filer;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.Modifier;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

public class InterfaceExtractorProcessor implements AnnotationProcessor{
	private final AnnotationProcessorEnvironment environment;
	private ArrayList<MethodDeclaration> interfaceMethods 
				= new ArrayList<MethodDeclaration>();
	public InterfaceExtractorProcessor(
			AnnotationProcessorEnvironment environment) {
		this.environment = environment;
	}
	@Override
	public void process() {
		// TODO Auto-generated method stub
		for (TypeDeclaration typeDeclaration : environment.getSpecifiedTypeDeclarations()){
			ExtractInterface annot = typeDeclaration.getAnnotation(ExtractInterface.class);
			if (annot == null){
				break;
			}
			for ( MethodDeclaration methodDeclaration :typeDeclaration.getMethods()) {
				if (methodDeclaration.getModifiers().contains(Modifier.PUBLIC)
						&& !methodDeclaration.getModifiers().contains(Modifier.STATIC)
						){
					interfaceMethods.add(methodDeclaration);
				}
			}
			if (interfaceMethods.size() > 0){
				try {
					Filer filer = environment.getFiler();
					PrintWriter writer =  filer.createSourceFile(annot.value());
					writer.println("package " + typeDeclaration.getPackage().getQualifiedName() +";");
					writer.println("public interface "+ annot.value() +" {");
					for (MethodDeclaration m: interfaceMethods) {
						writer.print("	public ");
						writer.print(m.getReturnType() + " ");
						writer.print(m.getSimpleName() + "( ");
						int i = 0;
						for (ParameterDeclaration parm: m.getParameters()) {
							writer.print(parm.getType() + " " + parm.getSimpleName());
							if (++i < m.getParameters().size()) {
								writer.print(", ");
							}
						}
						writer.print(");");
					}
					writer.println("}");
					writer.close();
					
				} catch (Exception e) {
					// TODO: handle exception
					throw new RuntimeException(e);
				}
			}
		}
	}

}
