package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IStore extends IStoreAbstract {
	protected IStore(final int index) {
		super(index);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ISTORE;
	}
}