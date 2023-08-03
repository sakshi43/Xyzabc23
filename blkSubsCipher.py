def pad(plaintext, block_size):
    padding_len = block_size - len(plaintext) % block_size
    padded_text = plaintext + " " * padding_len
    return padded_text


def unpad(padded_text):
    return padded_text.rstrip()


def block_encrypt(key, plaintext, block_size):
    padded_text = pad(plaintext, block_size)
    num_blocks = len(padded_text) // block_size
    ciphertext = ""

    for i in range(num_blocks):
        block = padded_text[i * block_size : (i + 1) * block_size]
        encrypted_block = ""
        for idx in key:
            encrypted_block += block[idx]
        ciphertext += encrypted_block

    return ciphertext


def block_decrypt(key, ciphertext, block_size):
    num_blocks = len(ciphertext) // block_size
    plaintext = ""

    for i in range(num_blocks):
        block = ciphertext[i * block_size : (i + 1) * block_size]
        decrypted_block = [""] * block_size
        for j, idx in enumerate(key):
            decrypted_block[idx] = block[j]
        plaintext += "".join(decrypted_block)

    return unpad(plaintext)


if __name__ == "__main__":
    key = [2, 0, 3, 1]  # Example key for transposition cipher
    plaintext = "This is a block cipher implementation."
    block_size = 4

    encrypted_text = block_encrypt(key, plaintext, block_size)
    decrypted_text = block_decrypt(key, encrypted_text, block_size)

    print("Plaintext:", plaintext)
    print("Encrypted:", encrypted_text)
    print("Decrypted:", decrypted_text)
