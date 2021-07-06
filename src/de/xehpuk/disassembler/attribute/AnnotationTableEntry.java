package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.Dumpable;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import java.util.Arrays;

/**
 *
 * @author xehpuk
 */
public class AnnotationTableEntry implements Dumpable {
	private final ConstantUtf8 type;
	private final ElementValuePair[] elementValuePairs;

	public AnnotationTableEntry(final ConstantUtf8 type, final ElementValuePair[] elementValuePairs) {
		this.type = type;
		this.elementValuePairs = elementValuePairs;
	}

	public ConstantUtf8 getType() {
		return type;
	}

	public ElementValuePair[] getElementValuePairs() {
		return elementValuePairs;
	}

	@Override
	public String toString() {
		return "AnnotationTableEntry{" + type + ", " + Arrays.toString(elementValuePairs) + '}';
	}

	@Override
	public void dump(final int indent) {
		type.dump(indent);
		System.out.println(':');
		for (final ElementValuePair elementValuePair : elementValuePairs) {
			elementValuePair.dump(indent + 1);
		}
	}
}