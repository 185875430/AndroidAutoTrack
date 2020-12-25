package com.wallstreetcn.autotrack.helper;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;

public abstract class FieldAnnotationVisitor extends FieldVisitor {

    private final String annotationName = "Lcom/wallstreetcn/sample/adapter/Test;";
    public String fieldName, fieldDesc;

    public FieldAnnotationVisitor(int i, FieldVisitor fieldVisitor, String fieldName, String fieldDesc) {
        super(i, fieldVisitor);
        this.fieldName = fieldName;
        this.fieldDesc = fieldDesc;
    }


    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        if (desc.equals(annotationName)) {
            hasAnnotation(fieldName, fieldDesc);
        }
        return super.visitAnnotation(desc, visible);
    }

    abstract void hasAnnotation(String fieldName, String fieldDesc);
}
