package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class AStore extends AStoreAbstract {
	protected AStore(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ASTORE;
	}
}