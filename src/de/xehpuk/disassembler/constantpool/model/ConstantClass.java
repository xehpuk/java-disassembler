package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantPoolEntry;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public class ConstantClass implements ConstantPoolEntry {
	private final ConstantUtf8 name;

	public ConstantClass(final ConstantUtf8 name) {
		this.name = name;
	}

	public ConstantUtf8 getName() {
		return name;
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.CLASS;
	}

	@Override
	public String toString() {
		return "ConstantClass{" + "name=" + name + '}';
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(Util.className(name.getString()));
	}
}