package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DStore extends DStoreAbstract {
	protected DStore(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.DSTORE;
	}
}