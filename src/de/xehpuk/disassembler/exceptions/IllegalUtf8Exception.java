package de.xehpuk.disassembler.exceptions;

import java.util.Arrays;

/**
 *
 * @author xehpuk
 */
public class IllegalUtf8Exception extends ConstantPoolReadException {
	private final byte[] bytes;

	public IllegalUtf8Exception(final byte[] bytes) {
		super(Arrays.toString(bytes));
		this.bytes = bytes;
	}

	public byte[] getBytes() {
		return bytes;
	}
}