package com.nc.edu.be.repository;

import com.nc.edu.be.entities.Subscriptions;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SubscriptionsRepository extends CrudRepository<Subscriptions, Integer>{
    @Modifying
    @Transactional
    @Query("update Subscriptions subscription set subscription.duration = subscription.duration - 1 where subscription.idSubscription = :id")
    void decreaseDuration(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("update Subscriptions subscription set subscription.duration = subscription.duration + :duration where subscription.idSubscription = :id")
    void extendDuration(@Param("id") Integer id, @Param("duration") int duration);
    @Modifying
    @Transactional
    @Query("update Subscriptions sub set sub.cost = :cost where sub.idSubscription = :idSubscription")
    void changeCost(@Param("id") Integer id, @Param("cost") float cost);

    @Modifying
    @Transactional
    @Query("update Subscriptions sub set sub.status = 0 where sub.idSubscription = :id")
    void falseStatus(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("update Subscriptions sub set sub.status = 1 where sub.idSubscription = :id")
    void trueStatus(@Param("id") Integer id);
}
