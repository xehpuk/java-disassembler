package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LStore extends LStoreAbstract {
	protected LStore(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.LSTORE;
	}
}