package de.xehpuk.disassembler.attribute;

/**
 *
 * @author xehpuk
 */
public class AttributeRuntimeInvisibleParameterAnnotations extends AttributeParameterAnnotations {
	public AttributeRuntimeInvisibleParameterAnnotations(final ParameterAnnotationTableEntry[] parameterAnnotations) {
		super(parameterAnnotations);
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS;
	}
}