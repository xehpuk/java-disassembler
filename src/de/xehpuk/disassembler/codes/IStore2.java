package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IStore2 extends IStoreAbstract {
	protected IStore2() {
		super(2);
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.ISTORE_2;
	}
}