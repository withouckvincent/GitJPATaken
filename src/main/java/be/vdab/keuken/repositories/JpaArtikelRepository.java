package be.vdab.keuken.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import be.vdab.keuken.domain.Artikel;

@Repository
class JpaArtikelRepository implements ArtikelRepository {
	private final EntityManager manager;

	JpaArtikelRepository(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Optional<Artikel> findById(long id) {
		return Optional.ofNullable(manager.find(Artikel.class, id));
	}
}
