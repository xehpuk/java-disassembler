package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.constants.TypeCharacter;

/**
 *
 * @author xehpuk
 */
public class AnnotationValue implements ElementValue {
	private final AnnotationTableEntry annotationValue;

	public AnnotationValue(final AnnotationTableEntry annotationValue) {
		this.annotationValue = annotationValue;
	}

	public AnnotationTableEntry getAnnotationValue() {
		return annotationValue;
	}

	@Override
	public TypeCharacter getType() {
		return TypeCharacter.ANNOTATION_TYPE;
	}
}