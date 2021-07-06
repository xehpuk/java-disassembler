package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.Dumpable;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;

/**
 *
 * @author xehpuk
 */
public class ElementValuePair implements Dumpable {
	private final ConstantUtf8 elementName;
	private final ElementValue value;

	public ElementValuePair(final ConstantUtf8 elementName, final ElementValue value) {
		this.elementName = elementName;
		this.value = value;
	}

	public ConstantUtf8 getElementName() {
		return elementName;
	}

	public ElementValue getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "ElementValuePair{" + elementName + ", " + value + '}';
	}

	@Override
	public void dump(final int indent) {
		elementName.dump(indent);
		System.out.println(", " + value);
	}
}