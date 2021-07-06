package de.xehpuk.disassembler.attribute;

/**
 *
 * @author xehpuk
 */
public class AttributeRuntimeVisibleParameterAnnotations extends AttributeParameterAnnotations {
	public AttributeRuntimeVisibleParameterAnnotations(final ParameterAnnotationTableEntry[] parameterAnnotations) {
		super(parameterAnnotations);
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS;
	}
}