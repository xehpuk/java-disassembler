package de.xehpuk.disassembler.reader;

import de.xehpuk.disassembler.ClassFile;
import de.xehpuk.disassembler.ClassFileBody;
import de.xehpuk.disassembler.ClassFileHead;
import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.exceptions.IllegalMagicException;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author xehpuk
 */
public class ClassFileReader extends Reader<ClassFile> {
	public ClassFileReader(final DataInput in) {
		super(in);
	}

	@Override
	public ClassFile read() throws IOException {
		final int magic = readInt();
		if (magic != ClassFile.MAGIC) {
			throw new IllegalMagicException(magic);
		}
		final ClassFileHead head = readClassFileHead();
		final ClassFileBody body = readClassFileBody(head.getConstantPool());
		return new ClassFile(head, body);
	}

	private ClassFileHead readClassFileHead() throws IOException {
		return new ClassFileHeadReader(this).read();
	}

	private ClassFileBody readClassFileBody(final ConstantPool constantPool) throws IOException {
		return new ClassFileBodyReader(this, constantPool).read();
	}

	public static void main(final String... args) throws IOException {
		if (args.length == 0) {
			System.err.println("Usage: java -jar disassembler.jar <class-file>");
			System.exit(-1);
		}
		try (final DataInputStream in = new DataInputStream(new FileInputStream(args[0]))) {
			final ClassFileReader reader = new ClassFileReader(in);
			final ClassFile file = reader.read();
			file.dump(1);
		}
	}
}