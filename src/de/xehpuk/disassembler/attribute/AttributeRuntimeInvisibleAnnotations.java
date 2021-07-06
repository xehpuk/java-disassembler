package de.xehpuk.disassembler.attribute;

/**
 *
 * @author xehpuk
 */
public class AttributeRuntimeInvisibleAnnotations extends AttributeAnnotations {
	public AttributeRuntimeInvisibleAnnotations(final AnnotationTableEntry[] annotations) {
		super(annotations);
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.RUNTIME_INVISIBLE_ANNOTATIONS;
	}
}