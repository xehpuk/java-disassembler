package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FStore extends FStoreAbstract {
	protected FStore(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.FSTORE;
	}
}