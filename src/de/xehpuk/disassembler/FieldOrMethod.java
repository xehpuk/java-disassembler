package de.xehpuk.disassembler;

import de.xehpuk.disassembler.attribute.Attribute;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;

/**
 *
 * @author xehpuk
 */
public abstract class FieldOrMethod implements Dumpable {
	private final AccessFlags accessFlags;
	private final ConstantUtf8 name;
	private final ConstantUtf8 descriptor;
	private final Attribute[] attributes;

	protected FieldOrMethod(final AccessFlags accessFlags, final ConstantUtf8 name, final ConstantUtf8 descriptor, final Attribute[] attributes) {
		this.accessFlags = accessFlags;
		this.name = name;
		this.descriptor = descriptor;
		this.attributes = attributes;
	}

	public AccessFlags getAccessFlags() {
		return accessFlags;
	}

	public ConstantUtf8 getName() {
		return name;
	}

	public ConstantUtf8 getDescriptor() {
		return descriptor;
	}

	public Attribute[] getAttributes() {
		return attributes;
	}
}