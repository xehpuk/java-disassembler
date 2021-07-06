package de.xehpuk.disassembler;

import de.xehpuk.disassembler.attribute.Attribute;
import de.xehpuk.disassembler.constantpool.model.ConstantClass;

/**
 *
 * @author xehpuk
 */
public final class ClassFileBody {
	private final ConstantClass thisClass;
	private final ConstantClass superClass;
	private final ConstantClass[] interfaces;
	private final Field[] fields;
	private final Method[] methods;
	private final Attribute[] attributes;

	public ClassFileBody(final ConstantClass thisClass, final ConstantClass superClass, final ConstantClass[] interfaces, final Field[] fields, final Method[] methods, final Attribute[] attributes) {
		this.thisClass = thisClass;
		this.superClass = superClass;
		this.interfaces = interfaces;
		this.fields = fields;
		this.methods = methods;
		this.attributes = attributes;
	}

	public ConstantClass getThisClass() {
		return thisClass;
	}

	public ConstantClass getSuperClass() {
		return superClass;
	}

	public ConstantClass[] getInterfaces() {
		return interfaces;
	}

	public Field[] getFields() {
		return fields;
	}

	public Method[] getMethods() {
		return methods;
	}

	public Attribute[] getAttributes() {
		return attributes;
	}
}