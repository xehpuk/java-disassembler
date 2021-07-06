package de.xehpuk.disassembler.exceptions;

/**
 *
 * @author xehpuk
 */
public class IllegalMagicException extends ClassFileReadException {
	private final int magic;

	public IllegalMagicException(int magic) {
		super(Integer.toHexString(magic));
		this.magic = magic;
	}

	public int getMagic() {
		return magic;
	}
}
