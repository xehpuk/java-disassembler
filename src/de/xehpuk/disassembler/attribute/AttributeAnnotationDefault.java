package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public class AttributeAnnotationDefault implements Attribute {
	private final ElementValue defaultValue;

	public AttributeAnnotationDefault(final ElementValue defaultValue) {
		this.defaultValue = defaultValue;
	}

	public ElementValue getDefaultValue() {
		return defaultValue;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.ANNOTATION_DEFAULT;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(getName().getName() + '=' + defaultValue.getType());
	}
}