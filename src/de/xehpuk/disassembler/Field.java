package de.xehpuk.disassembler;

import de.xehpuk.disassembler.attribute.Attribute;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import de.xehpuk.disassembler.util.Util;
import java.util.Arrays;

/**
 *
 * @author xehpuk
 */
public class Field extends FieldOrMethod {
	public Field(final AccessFlags accessFlags, final ConstantUtf8 name, final ConstantUtf8 descriptor, final Attribute[] attributes) {
		super(accessFlags, name, descriptor, attributes);
	}

	@Override
	public String toString() {
		return "FieldBytes{" + "accessFlags=" + getAccessFlags() + ", name=" + getName() + ", descriptor=" + getDescriptor() + ", attributes=" + Arrays.toString(getAttributes()) + '}';
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(getAccessFlags());
		System.out.print(Util.fieldDescriptor(getDescriptor().getString()));
		System.out.print(' ');
		getName().dump(0);
		System.out.println();
		for (final Attribute attribute : getAttributes()) {
			attribute.dump(indent + 1);
		}
	}
}