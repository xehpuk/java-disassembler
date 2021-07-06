package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IStore0 extends IStoreAbstract {
	protected IStore0() {
		super(0);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ISTORE_0;
	}
}