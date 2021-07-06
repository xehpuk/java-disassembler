package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import de.xehpuk.disassembler.exceptions.IllegalUtf8Exception;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author xehpuk
 */
public class ConstantUtf8Bytes implements ConstantPoolEntryRaw {
	private final byte[] bytes;

	public ConstantUtf8Bytes(final byte[] bytes) {
		this.bytes = bytes;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public int getLength() {
		return bytes.length;
	}

	@Override
	public String toString() {
		return "ConstantUtf8Info{" + "bytes=" + Arrays.toString(bytes) + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.UTF8;
	}

	@Override
	public ConstantUtf8 convert(final int index, final ConstantPool pool) {
		final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bytes.length);
		final DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
		try {
			dataOutputStream.writeShort(bytes.length);
			dataOutputStream.write(bytes);
			final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			final DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
			final String string = dataInputStream.readUTF();
			final ConstantUtf8 result = new ConstantUtf8(string);
			return result;
		} catch (final IOException ex) {
			throw new IllegalUtf8Exception(bytes);
		}
	}

	@Override
	public void dump(final int indent) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}