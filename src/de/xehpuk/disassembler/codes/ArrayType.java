package de.xehpuk.disassembler.codes;

import de.xehpuk.disassembler.exceptions.IllegalArrayTypeCodeException;
import java.util.HashMap;
import java.util.Map;

public enum ArrayType {
	BOOLEAN((byte) 4),
	CHAR((byte) 5),
	FLOAT((byte) 6),
	DOUBLE((byte) 7),
	BYTE((byte) 8),
	SHORT((byte) 9),
	INT((byte) 10),
	LONG((byte) 11);
	private static final Map<Byte, ArrayType> codeLookup = new HashMap<>(values().length);

	static {
		for (final ArrayType type : values()) {
			if (codeLookup.put(type.getCode(), type) != null) {
				throw new IllegalArrayTypeCodeException(type.getCode());
			}
		}
	}

	public static ArrayType from(final byte code) throws IllegalArrayTypeCodeException {
		final ArrayType result = codeLookup.get(code);
		if (result == null) {
			throw new IllegalArrayTypeCodeException(code);
		}
		return result;
	}
	private final byte code;

	private ArrayType(final byte code) {
		this.code = code;
	}

	public byte getCode() {
		return code;
	}
}