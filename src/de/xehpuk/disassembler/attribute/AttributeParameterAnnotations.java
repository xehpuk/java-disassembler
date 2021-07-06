package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public abstract class AttributeParameterAnnotations implements Attribute {
	private final ParameterAnnotationTableEntry[] parameterAnnotations;

	public AttributeParameterAnnotations(final ParameterAnnotationTableEntry[] parameterAnnotations) {
		this.parameterAnnotations = parameterAnnotations;
	}

	public ParameterAnnotationTableEntry[] getParameterAnnotations() {
		return parameterAnnotations;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(getName().getName() + ':');
		for (final ParameterAnnotationTableEntry parameterAnnotationTableEntry : parameterAnnotations) {
			parameterAnnotationTableEntry.dump(indent + 1);
		}
	}
}