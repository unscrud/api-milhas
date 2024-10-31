# Os testes utilizam o HTTPie disponível em https://httpie.io/
# para instalar com apt descomente o comando abaixo:
# sudo apt install httpie

# cadastrar usuários de exemplo 
http POST localhost:3000/auth/cadastro nome="João" email="joao@example.com" senha="senha123" telefone="11987654321" cpf="123.456.789-00" dataDeNascimento="01-01-1990" genero="masculino" cidade="São Paulo" estado="SP"
http POST localhost:3000/auth/cadastro nome="Maria" email="maria@example.com" senha="123456" telefone="21987654322" cpf="234.567.890-01" dataDeNascimento="02-02-1985" genero="feminino" cidade="Rio de Janeiro" estado="RJ"
http POST localhost:3000/auth/cadastro nome="José" email="jose@example.com" senha="12345678" telefone="81987654323" cpf="345.678.901-02" dataDeNascimento="03-03-1980" genero="masculino" cidade="Recife" estado="PE"
http POST localhost:3000/auth/cadastro nome="Ana" email="ana@example.com" senha="senhaAna123" telefone="11923456789" cpf="456.789.012-03" dataDeNascimento="04-04-1992" genero="feminino" cidade="Campinas" estado="SP"
http POST localhost:3000/auth/cadastro nome="Carlos" email="carlos@example.com" senha="senhaCarlos123" telefone="21923456789" cpf="567.890.123-04" dataDeNascimento="05-05-1986" genero="masculino" cidade="Niterói" estado="RJ"
http POST localhost:3000/auth/cadastro nome="Patrícia" email="patricia@example.com" senha="senhaPatricia123" telefone="31923456789" cpf="678.901.234-05" dataDeNascimento="06-06-1989" genero="feminino" cidade="Belo Horizonte" estado="MG"
http POST localhost:3000/auth/cadastro nome="Luís" email="luis@example.com" senha="senhaLuis123" telefone="41923456789" cpf="789.012.345-06" dataDeNascimento="07-07-1982" genero="masculino" cidade="Curitiba" estado="PR"
http POST localhost:3000/auth/cadastro nome="Fernanda" email="fernanda@example.com" senha="senhaFernanda123" telefone="51923456789" cpf="890.123.456-07" dataDeNascimento="08-08-1991" genero="feminino" cidade="Porto Alegre" estado="RS"
http POST localhost:3000/auth/cadastro nome="Ricardo" email="ricardo@example.com" senha="senhaRicardo123" telefone="61923456789" cpf="901.234.567-08" dataDeNascimento="09-09-1988" genero="masculino" cidade="Brasília" estado="DF"
http POST localhost:3000/auth/cadastro nome="Juliana" email="juliana@example.com" senha="senhaJuliana123" telefone="71923456789" cpf="012.345.678-09" dataDeNascimento="10-10-1984" genero="feminino" cidade="Salvador" estado="BA"
http POST localhost:3000/auth/cadastro nome="Felipe" email="felipe@example.com" senha="senhaFelipe123" telefone="81923456789" cpf="123.456.789-10" dataDeNascimento="11-11-1987" genero="masculino" cidade="Fortaleza" estado="CE"
http POST localhost:3000/auth/cadastro nome="Renata" email="renata@example.com" senha="senhaRenata123" telefone="91923456789" cpf="234.567.890-11" dataDeNascimento="12-12-1990" genero="feminino" cidade="Vitória" estado="ES"
http POST localhost:3000/auth/cadastro nome="Bruno" email="bruno@example.com" senha="senhaBruno123" telefone="11934567890" cpf="345.678.901-12" dataDeNascimento="13-01-1983" genero="masculino" cidade="São Paulo" estado="SP"
http POST localhost:3000/auth/cadastro nome="Simone" email="simone@example.com" senha="senhaSimone123" telefone="21934567890" cpf="456.789.012-13" dataDeNascimento="14-02-1985" genero="feminino" cidade="Rio de Janeiro" estado="RJ"
http POST localhost:3000/auth/cadastro nome="Marcos" email="marcos@example.com" senha="senhaMarcos123" telefone="31934567890" cpf="567.890.123-14" dataDeNascimento="15-03-1992" genero="masculino" cidade="Belo Horizonte" estado="MG"
http POST localhost:3000/auth/cadastro nome="Laura" email="laura@example.com" senha="senhaLaura123" telefone="41934567890" cpf="678.901.234-15" dataDeNascimento="16-04-1981" genero="feminino" cidade="Curitiba" estado="PR"
http POST localhost:3000/auth/cadastro nome="Tiago" email="tiago@example.com" senha="senhaTiago123" telefone="51934567890" cpf="789.012.345-16" dataDeNascimento="17-05-1980" genero="masculino" cidade="Porto Alegre" estado="RS"
http POST localhost:3000/auth/cadastro nome="Camila" email="camila@example.com" senha="senhaCamila123" telefone="61934567890" cpf="890.123.456-17" dataDeNascimento="18-06-1993" genero="feminino" cidade="Brasília" estado="DF"
http POST localhost:3000/auth/cadastro nome="André" email="andre@example.com" senha="senhaAndre123" telefone="71934567890" cpf="901.234.567-18" dataDeNascimento="19-07-1994" genero="masculino" cidade="Recife" estado="PE"
http POST localhost:3000/auth/cadastro nome="Sofia" email="sofia@example.com" senha="senhaSofia123" telefone="81934567890" cpf="012.345.678-19" dataDeNascimento="20-08-1992" genero="feminino" cidade="Fortaleza" estado="CE"
http POST localhost:3000/auth/cadastro nome="Gustavo" email="gustavo@example.com" senha="senhaGustavo123" telefone="91934567890" cpf="123.456.789-20" dataDeNascimento="21-09-1991" genero="masculino" cidade="Vitória" estado="ES"
http POST localhost:3000/auth/cadastro nome="Beatriz" email="beatriz@example.com" senha="senhaBeatriz123" telefone="11945678901" cpf="234.567.890-21" dataDeNascimento="22-10-1988" genero="feminino" cidade="São Paulo" estado="SP"
http POST localhost:3000/auth/cadastro nome="Júlio" email="julio@example.com" senha="senhaJulio123" telefone="21945678901" cpf="345.678.901-22" dataDeNascimento="23-11-1990" genero="masculino" cidade="Rio de Janeiro" estado="RJ"
http POST localhost:3000/auth/cadastro nome="Genovaldo" email="genovaldo@example.com" senha="123456789" telefone="81987654324" cpf="456.789.012-23" dataDeNascimento="24-12-1989" genero="masculino" cidade="Recife" estado="PE"

# listar usuários - decomentar quando for criado
# http GET localhost:3000/usuarios # tamanho da paginação padrão do spring (20)
# http GET localhost:3000/usuarios?size=10 # tamanho da paginação personalizada (10)
# http GET "localhost:3000/usuarios?page=0&size=5" # listando a primeira página com 5 itens
# http GET "localhost:3000/usuarios?page=1&size=5" # listando a segunda  página com 5 itens
# http GET localhost:3000/usuarios?sort=numeroDeCelular # ordenando pelo numero do telefone celular
# http GET "localhost:3000/usuarios?sort=numeroDeCelular,desc" # mesmo que anterior, mas decrescente
# http GET "localhost:3000/usuarios?sort=numeroDeCelular,desc&page=0&size=3" # misturando anteriores

# # Alterar uma senha  - decomentar quando for criado
# http PATCH localhost:3000/usuarios uuid="uuid-do-usuario" senha="nova-senha"
# 
# # deletar um usuario  - decomentar quando for criado
# http DELETE localhost:3000/usuarios/uuid-do-usuario
# 
# # obter um usuário pelo uuid - decomentar quando for criado
# http GET http://localhost:3000/usuarios/uuid-do-usuario
# 
# # testando erro de validação ao tentar criar um usuário
# http POST localhost:3000/usuarios primeiroNome="Fulano"
# 
# # obtendo um token ao efetuar o login
# http POST localhost:3000/login email="ana@example.com" senha="senhaAna123"
# 
# # realizando uma chamada com o token JWT
# http GET localhost:3000/usuarios Authorization:"Bearer SEU_TOKEN_JWT"

