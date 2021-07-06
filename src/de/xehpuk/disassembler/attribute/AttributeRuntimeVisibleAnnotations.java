package de.xehpuk.disassembler.attribute;

/**
 *
 * @author xehpuk
 */
public class AttributeRuntimeVisibleAnnotations extends AttributeAnnotations {
	public AttributeRuntimeVisibleAnnotations(final AnnotationTableEntry[] annotations) {
		super(annotations);
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.RUNTIME_VISIBLE_ANNOTATIONS;
	}
}