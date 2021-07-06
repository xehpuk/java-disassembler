package de.xehpuk.disassembler.reader;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.bytes.Constant8ByteBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantClassBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantDoubleBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantFieldrefBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantFloatBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantIntegerBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantInterfaceMethodrefBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantInvokeDynamicBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantLongBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantMethodHandleBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantMethodTypeBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantMethodrefBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantNameAndTypeBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantPoolEntryRaw;
import de.xehpuk.disassembler.constantpool.bytes.ConstantStringBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantUtf8Bytes;
import java.io.DataInput;
import java.io.IOException;

/**
 *
 * @author xehpuk
 */
public class ConstantPoolReader extends Reader<ConstantPool> {
	public ConstantPoolReader(final DataInput in) {
		super(in);
	}

	@Override
	public ConstantPool read() throws IOException {
		final int constantPoolCount = readUnsignedShort();
		final ConstantPool constantPool = new ConstantPool(constantPoolCount);
		for (int i = 1; i < constantPoolCount; i++) {
			final ConstantPoolEntryRaw constantPoolInfo = readConstantPoolInfo();
			constantPool.setRaw(i, constantPoolInfo);
			if (constantPoolInfo instanceof Constant8ByteBytes) {
				i++;
			}
		}
		return constantPool;
	}

	private ConstantPoolEntryRaw readConstantPoolInfo() throws IOException {
		final int constantPoolTag = readUnsignedByte();
		return readConstantPoolInfoWithTag(constantPoolTag);
	}

	private ConstantPoolEntryRaw readConstantPoolInfoWithTag(final int constantPoolTag) throws IOException {
		return ConstantTag.from(constantPoolTag).read(this);
	}

	public ConstantClassBytes readConstantClassInfo() throws IOException {
		final int nameIndex = readUnsignedShort();
		return new ConstantClassBytes(nameIndex);
	}

	public ConstantDoubleBytes readConstantDoubleInfo() throws IOException {
		final int highBytes = readInt();
		final int lowBytes = readInt();
		return new ConstantDoubleBytes(highBytes, lowBytes);
	}

	public ConstantFieldrefBytes readConstantFieldrefInfo() throws IOException {
		final int classIndex = readUnsignedShort();
		final int nameAndTypeIndex = readUnsignedShort();
		return new ConstantFieldrefBytes(classIndex, nameAndTypeIndex);
	}

	public ConstantFloatBytes readConstantFloatInfo() throws IOException {
		final int bytes = readInt();
		return new ConstantFloatBytes(bytes);
	}

	public ConstantIntegerBytes readConstantIntegerInfo() throws IOException {
		final int bytes = readInt();
		return new ConstantIntegerBytes(bytes);
	}

	public ConstantInterfaceMethodrefBytes readConstantInterfaceMethodrefInfo() throws IOException {
		final int classIndex = readUnsignedShort();
		final int nameAndTypeIndex = readUnsignedShort();
		return new ConstantInterfaceMethodrefBytes(classIndex, nameAndTypeIndex);
	}

	public ConstantInvokeDynamicBytes readConstantInvokeDynamicInfo() throws IOException {
		final int bootstrapMethodAttrIndex = readUnsignedShort();
		final int nameAndTypeIndex = readUnsignedShort();
		return new ConstantInvokeDynamicBytes(bootstrapMethodAttrIndex, nameAndTypeIndex);
	}

	public ConstantLongBytes readConstantLongInfo() throws IOException {
		final int highBytes = readInt();
		final int lowBytes = readInt();
		return new ConstantLongBytes(highBytes, lowBytes);
	}

	public ConstantMethodHandleBytes readConstantMethodHandleInfo() throws IOException {
		final int referenceKind = readUnsignedByte();
		final int referenceIndex = readUnsignedShort();
		return new ConstantMethodHandleBytes(referenceKind, referenceIndex);
	}

	public ConstantMethodTypeBytes readConstantMethodTypeInfo() throws IOException {
		final int descriptorIndex = readUnsignedShort();
		return new ConstantMethodTypeBytes(descriptorIndex);
	}

	public ConstantMethodrefBytes readConstantMethodrefInfo() throws IOException {
		final int classIndex = readUnsignedShort();
		final int nameAndTypeIndex = readUnsignedShort();
		return new ConstantMethodrefBytes(classIndex, nameAndTypeIndex);
	}

	public ConstantNameAndTypeBytes readConstantNameAndTypeInfo() throws IOException {
		final int nameIndex = readUnsignedShort();
		final int descriptorIndex = readUnsignedShort();
		return new ConstantNameAndTypeBytes(nameIndex, descriptorIndex);
	}

	public ConstantStringBytes readConstantStringInfo() throws IOException {
		final int stringIndex = readUnsignedShort();
		return new ConstantStringBytes(stringIndex);
	}

	public ConstantUtf8Bytes readConstantUtf8Info() throws IOException {
		final int length = readUnsignedShort();
		final byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			bytes[i] = readByte();
		}
		return new ConstantUtf8Bytes(bytes);
	}
}