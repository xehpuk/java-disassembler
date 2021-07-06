package de.xehpuk.disassembler.reader;

import de.xehpuk.disassembler.AccessFlags;
import de.xehpuk.disassembler.Field;
import de.xehpuk.disassembler.attribute.Attribute;
import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import java.io.DataInput;
import java.io.IOException;

/**
 *
 * @author xehpuk
 */
public class FieldsReader extends ReaderNeedingConstantPool<Field[]> {
	public FieldsReader(final DataInput in, final ConstantPool constantPool) {
		super(in, constantPool);
	}

	public FieldsReader(final ReaderNeedingConstantPool<?> reader) {
		super(reader);
	}

	@Override
	public Field[] read() throws IOException {
		final int fieldsCount = readUnsignedShort();
		final Field[] fields = new Field[fieldsCount];
		for (int i = 0; i < fieldsCount; i++) {
			fields[i] = readField();
		}
		return fields;
	}

	private Field readField() throws IOException {
		final int accessFlags = readUnsignedShort();
		final int nameIndex = readUnsignedShort();
		final ConstantUtf8 name = get(nameIndex, ConstantUtf8.class);
		final int descriptorIndex = readUnsignedShort();
		final ConstantUtf8 descriptor = get(descriptorIndex, ConstantUtf8.class);
		final Attribute[] attributes = new AttributesReader(this).read();
		return new Field(new AccessFlags(accessFlags, AccessFlags.Type.FIELD), name, descriptor, attributes);
	}
}