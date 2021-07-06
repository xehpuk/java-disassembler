package de.xehpuk.disassembler.reader;

import de.xehpuk.disassembler.ClassFileBody;
import de.xehpuk.disassembler.Field;
import de.xehpuk.disassembler.Method;
import de.xehpuk.disassembler.attribute.Attribute;
import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.model.ConstantClass;
import java.io.DataInput;
import java.io.IOException;

/**
 *
 * @author xehpuk
 */
public class ClassFileBodyReader extends ReaderNeedingConstantPool<ClassFileBody> {
	public ClassFileBodyReader(final DataInput in, final ConstantPool constantPool) {
		super(in, constantPool);
	}

	public ClassFileBodyReader(final ReaderNeedingConstantPool<?> reader) {
		super(reader);
	}

	@Override
	public ClassFileBody read() throws IOException {
		final ConstantClass thisClass = readThisClass();
		final ConstantClass superClass = readSuperClass();
		final ConstantClass[] interfaces = readInterfaces();
		final Field[] fields = readFields();
		final Method[] methods = readMethods();
		final Attribute[] attributes = readAttributes();
		return new ClassFileBody(thisClass, superClass, interfaces, fields, methods, attributes);
	}

	private ConstantClass readThisClass() throws IOException {
		final int thisClassIndex = readUnsignedShort();
		final ConstantClass thisClass = get(thisClassIndex, ConstantClass.class);
		return thisClass;
	}

	private ConstantClass readSuperClass() throws IOException {
		final int superClassIndex = readUnsignedShort();
		final ConstantClass superClass = get(superClassIndex, ConstantClass.class);
		return superClass;
	}

	private ConstantClass[] readInterfaces() throws IOException {
		final int interfacesCount = readUnsignedShort();
		final ConstantClass[] interfaces = new ConstantClass[interfacesCount];
		for (int i = 0; i < interfacesCount; i++) {
			final int interfaceIndex = readUnsignedShort();
			interfaces[i] = get(interfaceIndex, ConstantClass.class);
		}
		return interfaces;
	}

	private Field[] readFields() throws IOException {
		return new FieldsReader(this).read();
	}

	private Method[] readMethods() throws IOException {
		return new MethodsReader(this).read();
	}

	private Attribute[] readAttributes() throws IOException {
		return new AttributesReader(this).read();
	}
}